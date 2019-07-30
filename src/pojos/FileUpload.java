package pojos;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

}
