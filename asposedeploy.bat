@echo off
call mvn deploy:deploy-file -Durl=file:asposeapi/ -Dfile=lib/aspose-pdf-kit-4.7.0.jar -DgroupId=com.aspose -DartifactId=aspose.pdf.kit -Dpackaging=jar -Dversion=4.7.0

call mvn deploy:deploy-file -Durl=file:asposeapi/ -Dfile=lib/aspose-pdf-jdk14.jar -DgroupId=com.aspose -DartifactId=aspose.pdf.jdk -Dpackaging=jar -Dversion=14

call mvn deploy:deploy-file -Durl=file:asposeapi/ -Dfile=lib/aspose-words-14.4.1-jdk16.jar -DgroupId=com.aspose -DartifactId=aspose.words -Dpackaging=jar -Dversion=14.4.1

call mvn deploy:deploy-file -Durl=file:asposeapi/ -Dfile=lib/aspose-cells-8.0.2.jar -DgroupId=com.aspose -DartifactId=aspose.cells -Dpackaging=jar -Dversion=8.0.2

call mvn deploy:deploy-file -Durl=file:asposeapi/ -Dfile=lib/aspose-email-4.1.0.0-jdk16.jar -DgroupId=com.aspose -DartifactId=aspose.email -Dpackaging=jar -Dversion=4.1.0.0

call mvn deploy:deploy-file -Durl=file:asposeapi/ -Dfile=lib/aspose-barcode-5.8.0-jdk16.jar -DgroupId=com.aspose -DartifactId=aspose.barcode -Dpackaging=jar -Dversion=5.8.0