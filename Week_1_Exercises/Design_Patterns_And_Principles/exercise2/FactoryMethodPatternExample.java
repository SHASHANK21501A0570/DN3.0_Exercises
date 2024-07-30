public class FactoryMethodPatternExample {

    public interface Document {
        void open();
        void save();
        void close();
    }

    public static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Word Document is now open.");
        }
        @Override
        public void save() {
            System.out.println("Word Document has been saved.");
        }
        @Override
        public void close() {
            System.out.println("Word Document is now closed.");
        }
    }

    public static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("PDF Document is now open.");
        }
        @Override
        public void save() {
            System.out.println("PDF Document has been saved.");
        }
        @Override
        public void close() {
            System.out.println("PDF Document is now closed.");
        }
    }

    public static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Excel Document is now open.");
        }
        @Override
        public void save() {
            System.out.println("Excel Document has been saved.");
        }
        @Override
        public void close() {
            System.out.println("Excel Document is now closed.");
        }
    }

    public abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    public static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    public static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    public static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
