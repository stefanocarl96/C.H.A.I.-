import model.Suspect;
import org.junit.Test;
import service.SuspectAnalyser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SuspectAnalyserTest {

    @Test
    public void equal_suspects() {
        SuspectAnalyser analyser = new SuspectAnalyser();
        Suspect culprit = new Suspect("Maria", 26, 170, 76, "black", "brown", false);
        Suspect s1 = new Suspect("Maria", 26, 170, 76, "black", "brown", false);

        assertTrue(analyser.match(culprit, s1));
    }

    @Test
    public void very_similar_suspects() {
        SuspectAnalyser analyser = new SuspectAnalyser();
        Suspect culprit = new Suspect("Maria", 26, 170, 76, "black", "brown", false);
        Suspect s2 = new Suspect("maria", 25, 169, 75, "blonde", "red", false);

        assertTrue(analyser.match(culprit, s2));
    }

    @Test
    public void quite_similar_suspects() {
        SuspectAnalyser analyser = new SuspectAnalyser();
        Suspect culprit = new Suspect("Alessandra", 28, 60, 68, "blue", "brown", false);
        Suspect s3 = new Suspect("Maria", 26, 170, 76, "black", "brown", false);
        Suspect s4 = new Suspect("Giovanna", 24, 175, 55, "white", "black", false);

        assertTrue(analyser.match(culprit, s3));
        assertFalse(analyser.match(culprit, s4));
    }

    @Test
    public void completely_different_suspects() {
        SuspectAnalyser analyser = new SuspectAnalyser();
        Suspect culprit = new Suspect("Maria", 26, 170, 76, "black", "brown", false);
        Suspect s5 = new Suspect("Stefano", 22, 190, 95, "brown", "brown", true);
        Suspect s6 = new Suspect("Franco", 50, 160, 65, "black", "black", false);

        assertFalse(analyser.match(culprit, s5));
        assertFalse(analyser.match(culprit, s6));
    }

    @Test
    public void distinctive_suspects() {
        SuspectAnalyser analyser = new SuspectAnalyser();
        Suspect culprit = new Suspect("Maria", 26, 170, 76, "black", "brown", false);
        Suspect s7 = new Suspect("Maria", 26, 170, 76, "blonde", "blue", false);

        assertTrue(analyser.match(culprit, s7));
    }
}