
package com.hsbc.exception;

public final class ProductExceptions {

    private ProductExceptions() {
        // utility class - prevent instantiation
    }

    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException() { super(); }
        public ProductNotFoundException(String message) { super(message); }
        public ProductNotFoundException(String message, Throwable cause) { super(message, cause); }
    }

    public static class ProductCreateException extends RuntimeException {
        public ProductCreateException() { super(); }
        public ProductCreateException(String message) { super(message); }
        public ProductCreateException(String message, Throwable cause) { super(message, cause); }
    }

    public static class ProductUpdateException extends RuntimeException {
        public ProductUpdateException() { super(); }
        public ProductUpdateException(String message) { super(message); }
        public ProductUpdateException(String message, Throwable cause) { super(message, cause); }
    }

    public static class ProductDeleteException extends RuntimeException {
        public ProductDeleteException() { super(); }
        public ProductDeleteException(String message) { super(message); }
        public ProductDeleteException(String message, Throwable cause) { super(message, cause); }
    }

    public static class InvalidIdException extends RuntimeException {
        public InvalidIdException() { super(); }
        public InvalidIdException(String message) { super(message); }
        public InvalidIdException(String message, Throwable cause) { super(message, cause); }
    }
}

