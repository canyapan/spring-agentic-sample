# Getting Started

### Ollama setup for Mac

Install ollama and run on your local
```
$ brew install ollama
$ brew services start ollama
```

Pull `phi4-mini` or similar tools supporting model
```
$ ollama pull phi4-mini
```

### Call API
```
$ curl -X POST "http://localhost:8080/v1/agent/info" -H "Content-Type: application/json" -d '{"question": "Tell me a joke"}'
$ curl -X POST "http://localhost:8080/v1/agent/app"  -H "Content-Type: application/json" -d '{"service": "test-service", "instance": "test-service-102423", "memoryUsage": 0.951, "cpuUsageAverageLast1Min": 0.12, "latencyInMillisAverageLast1Min": 824}'
```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.0-SNAPSHOT/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.0-SNAPSHOT/gradle-plugin/packaging-oci-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.0-SNAPSHOT/reference/web/servlet.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/4.0.0-SNAPSHOT/reference/using/devtools.html)
* [LangChain4j](https://docs.langchain4j.dev/get-started)
* [Ollama](https://github.com/ollama/ollama?tab=readme-ov-file)
* [Phi4-mini model](https://ollama.com/library/phi4-mini)
