package io.github.confuser2188.launcherpac.misc;

public class StringObject {

    private String string, prefix = "", suffix = "";

    public StringObject(String string){
        this.string = string;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return prefix + string + suffix;
    }
}
