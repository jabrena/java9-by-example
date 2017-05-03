package org.java9.by.example.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappingTest extends BaseTest{

    static {
        BaseTest.setupLogger(MappingTest.class);
    }

    class Blog {
        private final String id;
        private final String authorName;
        private final List<String> comments;

        String getAuthorName() {
            return authorName;
        }

        List<String> getComments() {
            return comments;
        }

        Blog(String id, String authorName, String... comments) {
            this.id = id;
            this.authorName = authorName;
            this.comments = Arrays.asList(comments);
        }

        @Override
        public String toString(){
            return "id:" + id + " author: " + this.authorName + " comments: " + this.comments;
        }
    }

    private Supplier<Stream<Blog>> blogs() {
        Blog blog1 = new Blog("1", "Brena", "Very Nice");
        Blog blog2 = new Blog("2", "Brena", "Cool", "Superb");
        Blog blog3 = new Blog("3", "Medina", "Ok", "Could be better");
        Blog blog4 = new Blog("4", "Medina", "Boring");
        return () -> List.of(blog1, blog2, blog3, blog4).stream();
    }


    @Test
    public void simpleCollectMappingTest() {
        blogs()
                .get()
                .collect(
                        Collectors.groupingBy(Blog::getAuthorName))
                .entrySet()
                .forEach(trace);
    }


    @Test
    public void collectMappingTest() {
        blogs()
                .get()
                .collect(
                        Collectors.groupingBy(Blog::getAuthorName,
                                Collectors.mapping(Blog::getComments, Collectors.toList())))
                .entrySet()
                .forEach(trace);
    }

    @Test
    public void flatMappingCollectorTest() {
        blogs()
                .get()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.flatMapping(blog -> blog.getComments().stream(),
                                Collectors.toList())))
                .entrySet()
                .forEach(trace);

    }
}
