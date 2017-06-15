package com.example.fileexplorerexternalstoragedemo;

/**
 * Created by Home on 6/14/2017.
 */

public class FileItem {
    public int ic;
    public String nm;
    public String modi;
    public String size;

    public FileItem(int ic,String nm,String modi, String size){
        this.ic=ic;
        this.nm=nm;
        this.modi=modi;
        this.size=size;
    }
}
