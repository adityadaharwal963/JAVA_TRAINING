public class GcpStorageService implements CloudStorageService {

    @Override
    public void uploadFile(String fileName) {
        System.out.println("Uploading File: "+fileName+" on GCP");
    }

    @Override
    public void downloadFile(String fileName) {
        System.out.println("Downloading File: "+fileName+" from GCP");
    }
}
