package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
 */
public class Kata9 {
	public static List<Map> execute() {
		List<MovieList> movieLists = DataUtil.getMovieLists();

		return movieLists.stream().flatMap(m -> m.getVideos().stream())
				.map(d -> ImmutableMap.of("id", d.getId(), "title", d.getTitle(), "time",
						d.getInterestingMoments().stream().filter(c -> c.getType().equals("Middle")), "url",
						d.getUri()))
				.collect(Collectors.toList());
	}
}
