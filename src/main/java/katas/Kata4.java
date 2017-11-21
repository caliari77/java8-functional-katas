package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
 */
public class Kata4 {
	public static List<Map> execute() {
		List<MovieList> movieLists = DataUtil.getMovieLists();

		return 	movieLists.stream()
				.map(listaDeFilmes -> listaDeFilmes.getVideos())
				.flatMap(videos -> videos.stream())
				.map(d -> ImmutableMap.of("id", d.getId(), "title", d.getTitle(), "boxart", d.getBoxarts() ))
				.collect(Collectors.toList());
	}
}
