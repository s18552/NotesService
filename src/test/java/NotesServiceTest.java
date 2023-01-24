import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.*;


class NotesServiceTest {

    private NotesService notesService;

    private NotesStorage notesStorage;

    @BeforeEach
    public void setUp() {
        notesService = EasyMock.createMock(NotesService.class);
        notesStorage = EasyMock.createMock(NotesStorage.class);
    }

    @Test
    public void testAddNote(){
        Note a = new Note("a", 1f);
        notesStorage.add(a);
        replay(notesStorage);
    }


    @Test
    public void testAverage() {
        Note a = new Note("a", 1f);
        notesService.add(a);
        EasyMock.expect(notesService.averageOf("a")).andReturn(1f);
        replay(notesService);

    }

    @Test
    public void testClearNotes() {
        Note note1 = new Note("a", 1f);
        Note note2 = new Note("b", 2f);
        Note note3 = new Note("c", 3f);
        Note note4 = new Note("d", 4f);

        notesService.add(note1);
        notesService.add(note2);
        notesService.add(note3);
        notesService.add(note4);
        notesService.clear();

        replay(notesService);
        assertEquals(notesStorage.getAllNotesOf("a"), null);

    }

    @AfterEach
    public void tearDown() {
        notesService = null;
        notesStorage = null;
    }


}