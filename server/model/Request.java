package server.model;

import com.beust.jcommander.Parameter;

public class Request {
    @Parameter( names = "-t", required = true)
    private String type;

    @Parameter (names = "-k")
    private String key;

    @Parameter( names = "-v")
    private String value;

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
