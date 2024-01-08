package librarymanagement;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	class Book {
	    private int bookId;
	    private String title;
	    private boolean isAvailable;

	    public Book(int bookId, String title) {
	        this.bookId = bookId;
	        this.title = title;
	        this.isAvailable = true;
	    }

	    public int getBookId() {
	        return bookId;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public boolean isAvailable() {
	        return isAvailable;
	    }

	    public void setAvailable(boolean available) {
	        isAvailable = available;
	    }
	}

	class User {
	    private int userId;
	    private String name;

	    public User(int userId, String name) {
	        this.setUserId(userId);
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
	}

	class Library {
	    private List<Book> books;

	    public Library() {
	        this.books = new ArrayList<>();
	    }

	    public void addBook(Book book) {
	        books.add(book);
	    }

	    public void removeBook(int bookId) {
	        books.removeIf(book -> book.getBookId() == bookId);
	    }

	    public void borrowBook(int bookId, User user) {
	        for (Book book : books) {
	            if (book.getBookId() == bookId && book.isAvailable()) {
	                book.setAvailable(false);
	                System.out.println(user.getName() + " borrowed " + book.getTitle());
	                return;
	            }
	        }
	        System.out.println("Book not available or does not exist.");
	    }

	    public void returnBook(int bookId, User user) {
	        for (Book book : books) {
	            if (book.getBookId() == bookId && !book.isAvailable()) {
	                book.setAvailable(true);
	                System.out.println(user.getName() + " returned " + book.getTitle());
	                return;
	            }
	        }
	        System.out.println("Invalid book ID or book is already available.");
	    }
	}

	public class LibraryManagement {
	    public static void main(String[] args) {
	        Library library = new Library();

	        Book book1 = new Book(101, "Java Programming");
	        Book book2 = new Book(102, "Data Structures");

	        User user1 = new User(1, "John Doe");

	        library.addBook(book1);
	        library.addBook(book2);

	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("1. Borrow a Book");
	            System.out.println("2. Return a Book");
	            System.out.println("3. Exit");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter the Book ID to borrow:");
	                    int borrowId = scanner.nextInt();
	                    library.borrowBook(borrowId, user1);
	                    break;
	                case 2:
	                    System.out.println("Enter the Book ID to return:");
	                    int returnId = scanner.nextInt();
	                    library.returnBook(returnId, user1);
	                    break;
	                case 3:
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	    }
	}


