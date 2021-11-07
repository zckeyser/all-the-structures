FROM golang:1.14.3-alpine AS build
WORKDIR /src
ENV CGO_ENABLED=0

COPY . .

ENTRYPOINT [ "go", "test", "./..." ]
# ARG TARGETOS
# ARG TARGETARCH
# RUN GOOS=${TARGETOS} GOARCH=${TARGETARCH} go build -o /out/example .

# FROM scratch AS bin-unix
# COPY --from=build /out/example /

# FROM bin-unix AS bin-linux
# FROM bin-unix AS bin-darwin

# FROM scratch AS bin-windows
# COPY --from=build /out/example /example.exe

# FROM bin-${TARGETOS} AS bin
