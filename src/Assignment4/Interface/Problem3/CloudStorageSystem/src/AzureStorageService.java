public class AzureStorageService implements CloudStorageService {
    @Override
    public void uploadFile(String fileName) {
        System.out.println("Uploading File: "+fileName+" on Azure");
    }

    @Override
    public void downloadFile(String fileName) {
        System.out.println("Downloading File: "+fileName+" from Azure");
    }
}
