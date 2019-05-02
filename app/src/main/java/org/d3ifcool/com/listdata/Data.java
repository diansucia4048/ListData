package org.d3ifcool.com.listdata;

public class Data {
    private int image;
    private String name, version, description;

    public Data(int image, String name, String version, String description) {
        this.image = image;
        this.name = name;
        this.version = version;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }
}
