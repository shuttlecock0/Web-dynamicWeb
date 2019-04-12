package imageAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult<T> {
	String lastBuildDate;	// "Thu, 07 Mar 2019 10:09:30 +0900",
	int total;				// ": 4637078,
	int start;				// "start": 1,
	int display;			// ": 10,
	T[] items;
}
