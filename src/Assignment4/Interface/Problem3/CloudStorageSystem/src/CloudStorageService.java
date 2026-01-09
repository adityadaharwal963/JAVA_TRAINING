public interface CloudStorageService {

    void uploadFile(String fileName);
    void downloadFile(String fileName);
    public int getUploadCount();
    public  void incrementUploadCount();
    default void retryService(){
        System.out.println("Retrying Service...");
        System.out.println("Connecting Cloud Provider");
    }
}
