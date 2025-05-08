/**
 * 
 */

/**
 * @author coley
 *
 */
public class task implements Comparable<task>{

		private int created;
		
		private int due;
		
		private String name;
		
		public int getCreated() {
			return created;
		}
		public int getDue() {
			return due;
		}
		public String getName() {
			return name;
		}
		public int compareTo(task o) {
			return o.getDue() - 0;
		}
		
		public String toString(){
			String toBeReturnedString = (created + "   " + name + "   " + due);
			return toBeReturnedString;
		}
		public task(String nameIn, int dueIn, int createdIn) {
			due = dueIn;
			name = nameIn;
			created = createdIn;
		};
}

