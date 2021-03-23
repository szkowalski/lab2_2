package edu.iis.mto.similarity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import edu.iis.mto.searcher.SearchResult;
import edu.iis.mto.searcher.SequenceSearcher;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimilarityFinderTest {

    @Test
    public void equalSequencesTest()
    {
        SimilarityFinder finder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(true).build());
        int [] seq1= {0,1,2,3};
        int [] seq2= {0,1,2,3};
        assertEquals(1, finder.calculateJackardSimilarity(seq1, seq2));
    }
    @Test
    public void notEqualSequencesTest()
    {
        SimilarityFinder finder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(false).build());
        int [] seq1= {1,2,3,4};
        int [] seq2= {5,6,7,8};
        assertEquals(0.0, finder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test
    public void halfEqualSequencesTest()
    {
        SimilarityFinder finder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(true).build());
        int [] seq1={1,2} ;
        int [] seq2={1,2,3,4} ;
        assertEquals(0.5, finder.calculateJackardSimilarity(seq1, seq2));
    }

    @Test
    public void emptySequencesTest()
    {
        SimilarityFinder finder = new SimilarityFinder(null);
        int [] seq1= {};
        int [] seq2= {};
        assertEquals(1, finder.calculateJackardSimilarity(seq1, seq2));
    }

}
