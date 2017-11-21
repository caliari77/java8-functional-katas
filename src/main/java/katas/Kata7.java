package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
 */
public class Kata7 {
	public static List<Map> execute() {
		List<MovieList> movieLists = DataUtil.getMovieLists();

		return
				movieLists.stream()
				.flatMap(mLists -> mLists.getVideos().stream())
				.map( d -> ImmutableMap.of("id", d.getId(), "title", d.getTitle(), "boxart",

						d.getBoxarts().stream()
						.reduce((b1, b2) ->  Math.multiplyExact( b1.getHeight() , b1.getWidth()) <
								Math.multiplyExact( b1.getHeight() , b1.getWidth()) ? b1 : b2)
						.map( BoxArt::getUrl )
						.orElse("")
						) )
				.collect(Collectors.toList());

	}
}
