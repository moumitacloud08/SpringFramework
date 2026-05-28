"# javasoap-webservice-example" 

http://localhost:8080/services/ click on the link -> WSDL : {http://soap.ws.example.com/}HelloWsService http://localhost:8080/services/hello?wsdl

cxf.path=/ tells Apache cxf that at runtime please do not use /services but expose out all my endpoints at the root level itself under our web application context

when we add below properties file the link will be http://localhost:8080/hellows/ server.servlet.context-path=/hellows cxf.path=/

Mark a class with @WebService to make it a soap endpoint and mark a method with @WebMethod
