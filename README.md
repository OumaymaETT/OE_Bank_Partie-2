## Project Dockerization

This project uses Docker to build and run a containerized version of the Java application.

---

### **Instructions**

#### **1. Build the Docker image**
To build the Docker image for the project, run the following command in the project directory (where the `Dockerfile` is located):
```bash
docker build -t oe-bank .
#### **2.  Run the container**
To run the Docker container and execute the Java application, use the following command:
```bash
docker run --rm oe-bank