package model;

public class Author {

		private int AuthorID;
		private String AuthorName;
		private String AuthorDOB;
		private String AuthorNation;
		private String AuthorImg;
				
		public Author(String authorName, String authorDOB, String authorNation, String authorImg) {
			AuthorName = authorName;
			AuthorDOB = authorDOB;
			AuthorNation = authorNation;
			AuthorImg = authorImg;
		}

		public Author(int authorID, String authorName, String authorDOB, String authorNation, String authorImg) {
			AuthorID = authorID;
			AuthorName = authorName;
			AuthorDOB = authorDOB;
			AuthorNation = authorNation;
			AuthorImg = authorImg;
		}


		public int getAuthorID() {
			return AuthorID;
		}

		public void setAuthorID(int authorID) {
			AuthorID = authorID;
		}


		public String getAuthorName() {
			return AuthorName;
		}

		public void setAuthorName(String authorName) {
			AuthorName = authorName;
		}


		public String getAuthorDOB() {
			return AuthorDOB;
		}

		public void setAuthorDOB(String authorDOB) {
			AuthorDOB = authorDOB;
		}


		public String getAuthorNation() {
			return AuthorNation;
		}

		public void setAuthorNation(String authorNation) {
			AuthorNation = authorNation;
		}


		public String getAuthorImg() {
			return AuthorImg;
		}

		public void setAuthorImg(String authorImg) {
			AuthorImg = authorImg;
		}


		@Override
		public String toString() {
			return "Author [AuthorID=" + AuthorID + ", AuthorName=" + AuthorName + ", AuthorDOB=" + AuthorDOB
					+ ", AuthorNation=" + AuthorNation + ", AuthorImg=" + AuthorImg + "]";
		}
		
		
}
