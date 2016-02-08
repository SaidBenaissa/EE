package ua.org.oa.oatkachenko.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Oleg on 03.02.2016.
 */
@MultipartConfig
public class Uploader extends HttpServlet {
    private boolean exception = false;
    private boolean info = false;
    private List<String> exceptionMessages;
    private List<String> infoMessages;
    private List<String> uploadedImg;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        findUploadedImg();
        request.setAttribute("uploadedImg", uploadedImg);
        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        exceptionMessages = new ArrayList<>();
        infoMessages = new ArrayList<>();
        Collection<Part> parts = request.getParts();

        parts.forEach(part -> {
            System.out.println(part.getName());
            if (isPartAnImage(part)) {
                saveFile(part);
            }
        });

        findUploadedImg();
        request.setAttribute("exception", exception);
        request.setAttribute("info", info);
        request.setAttribute("exceptionMessages", exceptionMessages);
        request.setAttribute("infoMessages", infoMessages);
        request.setAttribute("uploadedImg", uploadedImg);

        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }

    private boolean isPartAnImage(Part part) {
        if (part != null && part.getName().equals("file")) {
            switch (part.getContentType()) {
                case "image/jpeg":
                case "image/png":
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    private void saveFile(Part part) {
        String path = getUploadPath();
        String fileName = part.getSubmittedFileName();

        checkDir(path);

        try (FileOutputStream fileOutputStream =
                     new FileOutputStream(
                             new File(
                                     path + File.separator + System.currentTimeMillis() + fileName));
             InputStream filecontent = part.getInputStream()) {

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, read);
            }
            info = true;
            infoMessages.add(fileName);
        } catch (IOException e) {
            exception = true;
            exceptionMessages.add(e.getMessage());
        }
    }

    private String getUploadPath() {
        return Listener.getContextPath();
    }

    private void checkDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    private void findUploadedImg() {
        uploadedImg = new LinkedList<>();
        File dir = new File(getUploadPath());
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                String imgPath = "upload" + File.separator + file.getName();
                uploadedImg.add(imgPath);
            }
        }
    }
}