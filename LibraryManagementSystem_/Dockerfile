FROM busybox
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

FROM gcr.io/distroless/java:8
LABEL pipelineName="javawebapi" \
      pipelineKey="pipelinekey" \
      offeringKey="offeringkey"
COPY --from=0 /etc/passwd /etc/passwd
COPY target/LibraryManagementSystem_*.jar app.jar
USER appuser
CMD ["/app.jar"]