package mvc.controllers;

import mvc.interfaces.IDocumentalPersistenciaDatos;
import mvc.models.documental.DocumentalModel;
import mvc.view.DocumentalView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class DocumentalControllerTest {

    private DocumentalController controller;
    private DocumentalView mockView;
    private IDocumentalPersistenciaDatos mockPersistencia;

    @BeforeEach
    void setUp() {
        // Create mocks
        mockView = Mockito.mock(DocumentalView.class);
        mockPersistencia = Mockito.mock(IDocumentalPersistenciaDatos.class);

        // Initialize the controller with mocks
        controller = new DocumentalController(mockView, mockPersistencia);
    }

    @Test
    void  testAgregarDocumental() {
        // Arrange: Set up mock behavior for user input
        when(mockView.ingresarTituloDocumental()).thenReturn("Test Title");
        when(mockView.ingresarDuracionMinutos()).thenReturn(90);
        when(mockView.ingresarGeneroDocumental()).thenReturn("Documentary");
        when(mockView.ingresarInvestigadoresDocumental()).thenReturn(new ArrayList<>());

        // Act: Call the method that adds a new documental
        controller.menuDocumental(); // Simulate calling the menu and option 1 to add documental

        // Assert: Verify that the new documental was added to the list and persisted
        verify(mockPersistencia).guardarDatos(any(ArrayList.class));
        assertEquals(1, controller.documentales.size());
        assertEquals("Test Title", controller.documentales.get(0).getTitulo());
    }

    @Test
    void testUploadObjetos() {
        // Arrange: Mock the persistence layer to return pre-loaded data
        ArrayList<DocumentalModel> loadedDocumentales = new ArrayList<>();
        loadedDocumentales.add(new DocumentalModel("Loaded Title", 120, "History", new ArrayList<>()));
        when(mockPersistencia.leerDatos()).thenReturn(loadedDocumentales);

        // Act: Call the method to upload objects
        controller.uploadObjetos();

        // Assert: Verify that the list in memory was populated
        assertEquals(1, controller.documentales.size());
        assertEquals("Loaded Title", controller.documentales.get(0).getTitulo());
    }

    @Test
    void testMenuDocumental_Exit() {
        // Arrange: Simulate the user choosing the exit option
        when(mockView.mostrarDocumentalMenu()).thenReturn(3);

        // Act: Call the menu method
        controller.menuDocumental();

        // Assert: Ensure that no documentales were added and it exited correctly
        verify(mockView, times(1)).mostrarDocumentalMenu();
        verifyNoMoreInteractions(mockPersistencia);
    }
}
