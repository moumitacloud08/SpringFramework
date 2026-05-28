package com.spring.auto.configuration.filestore.network;

import com.spring.auto.configuration.filestore.FileStore;

class NetworkFileStore implements FileStore {
    @Override
    public void printFileStoreInfo() {
        System.out.println("network filestore");
    }
}
