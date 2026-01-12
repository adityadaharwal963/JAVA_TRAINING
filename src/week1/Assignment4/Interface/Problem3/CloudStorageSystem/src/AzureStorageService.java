public class AzureStorageService implements CloudStorageService {
    private static int uploadCount = 0;

    public  int getUploadCount() {
        return uploadCount;
    }

    public  void incrementUploadCount() {
        AzureStorageService.uploadCount = uploadCount+1;
    }
    @Override
    public void uploadFile(String fileName) {
        retryService();
        System.out.println("Uploading File: "+fileName+" on Azure");
        System.out.println("Total file uploaded: "+getUploadCount());
    }

    @Override
    public void downloadFile(String fileName) {
        retryService();
        System.out.println("Downloading File: "+fileName+" from Azure");
    }
}
