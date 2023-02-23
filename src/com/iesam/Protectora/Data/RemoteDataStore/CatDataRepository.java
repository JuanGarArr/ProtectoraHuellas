package com.iesam.Protectora.Data.RemoteDataStore;

public class CatDataRepository {

    private ApiClient apiClient = new ApiClient();

    public List<Cat> getCats() {
        try {
            Response<List<Cat>> responseCats = apiClient.apiService.getCats().execute();
            if (responseCats.isSuccessful()) {
                return responseCats.body();
            } else {
                throw new RuntimeException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
