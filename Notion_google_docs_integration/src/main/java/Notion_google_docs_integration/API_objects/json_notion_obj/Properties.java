package Notion_google_docs_integration.API_objects.json_notion_obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {
    Name name;

    @JsonProperty("Name")
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
