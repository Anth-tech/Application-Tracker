/*
package com.anth.applicationtracker.json;

import com.anth.applicationtracker.model.Application;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ApplicationJsonComponent {

    public static class Serializer extends JsonSerializer<Application> {

        @Override
        public void serialize(Application application, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
            jgen.writeStartObject();
            jgen.writeObjectField("appuser", application.getAppUser());
            jgen.writeStringField("job title", application.getJobTitle());
            jgen.writeStringField("job type", application.getJobType());
            jgen.writeObjectField("company", application.getCompany());
            jgen.writeStringField("location", application.getLocation());
            jgen.writeStringField("submission site", application.getSubmissionSite());
            jgen.writeStringField("submission status", application.getSubmissionStatus());
            jgen.writeStringField("response", application.getResponse());
            jgen.writeEndObject();
        }
    }
}

 */
