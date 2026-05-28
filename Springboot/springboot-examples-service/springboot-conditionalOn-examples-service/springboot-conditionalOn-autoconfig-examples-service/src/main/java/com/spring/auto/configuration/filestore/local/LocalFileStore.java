package com.spring.auto.configuration.filestore.local;

import com.spring.auto.configuration.filestore.FileStore;

class LocalFileStore implements FileStore {
    @Override
    public void printFileStoreInfo() {
        System.out.println("local filestore");
    }
}
