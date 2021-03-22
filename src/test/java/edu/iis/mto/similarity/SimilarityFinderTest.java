package edu.iis.mto.similarity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import edu.iis.mto.searcher.SearchResult;
import edu.iis.mto.searcher.SequenceSearcher;
import org.junit.jupiter.api.Test;

class SimilarityFinderTest {
    SimilarityFinder finder = new SimilarityFinder(new SequenceSearcher() {
        @Override
        public SearchResult search(int elem, int[] sequence) {
            for(int i=0; i<sequence.length;i++)
            {
                if(sequence[i]==elem){
                    return SearchResult.builder().withFound(true).withPosition(i).build();
                }
            }
            return SearchResult.builder().withFound(false).build();
        }
    });
    @Test
    public void equalSequencesTest()
    {
        int [] seq1= {0,1,2,3};
        int [] seq2= {0,1,2,3};
        assertEquals(1, finder.calculateJackardSimilarity(seq1, seq2));
    }
    @Test
    public void notEqualSequencesTest()
    {
        int [] seq1= {1,2,3,4};
        int [] seq2= {5,6,7,8};
        assertEquals(0.0, finder.calculateJackardSimilarity(seq1, seq2));
    }

}
