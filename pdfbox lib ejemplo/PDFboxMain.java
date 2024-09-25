

package PDFboxMain;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
// import java.text.SimpleDateFormat;
// import java.util.Calendar;
// import java.util.Date;
// import java.util.GregorianCalendar;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
// import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
// import org./apache.pdfbox.pdmodel.encryption.AccessPermission;
// import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDFboxMain {

    public static void main(String[] args) throws IOException {

        // si el archivo no existe, lo creamos
        PDDocument doc = new PDDocument();

        // si existe lo podemos cargar
        // llamamos el pdf que queremos cargar
        // File arch = new File("D:\\Personal Data\\CLASES U\\Progra\\Java\\PDFpractica\\PDFbox Test3\\TEST.PDF");
        // PDDocument doc = Loader.loadPDF(arch); // lo cargamos con la libreria LOADER --importante

        System.out.println("PDF cargado");

        PDPage pagina = new PDPage();
        // creamos y añadimos una pagina en BLANCO
        for (int i = 0; i < 1; i++) // creamos 3 paginas en blanco al FINAL del doc
            doc.addPage(pagina);
        //}

        // doc.removePage(2);//elimina la pagina 3

        /* AccessPermission acces = new AccessPermission(); // creamos el objeto de segurad, permiso de acceso. Esto nos
                                                         // servira para "encriptar" el documento
        StandardProtectionPolicy contra = new StandardProtectionPolicy("1234", "1234", acces); // creamos una contraseña
        contra.setEncryptionKeyLength(
          128); // tamaño de la contraseña que el usuario y tu pueden registrar TIene que ser; 40, 128 o 256
        contra.setPermissions(acces); // este metodo acepta objetos del tipo: AccessPermission
        doc.protect(contra);  */         // registramos la contraseña y sus configuraciones al doc

        // escribiendo TEXTO:
        int numPag = doc.getNumberOfPages();
        System.out.println(numPag);
        // tomamos la pagina en la queremos escribir.
        PDPage hoja = doc.getPage(0);
        // ahora, para poner informacion en la primera hoja. tenemos que empezar el "flujo de contenido"
        // con el objeto "Content Stream" incializamos todo para el cambio de la hoja..

        // PDImageXObject pdImage = PDImageXObject.createFromFile("C:/logo.png", doc);
        PDImageXObject imagen = PDImageXObject.createFromFile("D:\\Background.jpg", doc);
        // para poner imagenes nesesitamos un objeto de imagen, para esto usamos pdimage, requiere la dirreccion de
        // donde sacar la imagen y el archivo donde lo guardaremos

        PDPageContentStream flujo = new PDPageContentStream(doc, hoja);

        flujo.drawImage(imagen, 0,
                        250); // tener en cuenta que esto ignora las letras. Osea que se pone por debajo de estas..
                              // los datos dados, son las coordenadas donde va la imagen, la esquina inferior izquierda
                              // es 0,0.. x,y mas o menos el maximo de la hoja en altura es 680

        flujo.beginText();

        flujo.newLineAtOffset(25, 25); //""cordenada"" donde empieza a escribir
        flujo.setLeading(14.5f);       // espacio entre lineas..
        // contentStream.setFont( font_type, font_size );
        flujo.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12); // fuente y tamaño de letras
        // bendito es stackOverflow
        // -https://stackoverflow.com/questions/76985722/how-to-set-font-on-org-apache-pdfbox-while-migrating-from-3-0-0-rc1-to-3-0-0

        // ahora lo que queremos escribir..

        String texto = "Mi nombre es Patricio y soy un estudiante de momento";
        String texto2 = "Palabras de segunda linea--  --";
        flujo.showText(texto);
        flujo.newLine(); // saltamos a la siguiente linea
        flujo.showText(texto2);

        flujo.endText();
        flujo.close();

        // guardamos el documento
        // si lo guerdas igual a donde lo cargaste se va a reescribir, es posible que se corrompa dependiendo de los
        // cambios
        doc.save("D:\\Personal Data\\CLASES U\\Progra\\Java\\PDFpractica\\PDFbox Test3\\TEST.PDF");

        // cerramos archivo
        doc.close();

        /**
         * @brief Ejemplo de Splitter
         */

        // Cargar archivo
        File arch2 = new File("D:\\Personal Data\\CLASES U\\Progra\\Java\\PDFpractica\\PDFbox Test3\\TEST.PDF");
        PDDocument doc2 = Loader.loadPDF(arch2); // lo cargamos con la libreria LOADER --importante

        PDPage pagina2 = new PDPage();
        // creamos y añadimos una pagina en BLANCO
        for (int i = 0; i < 2; i++) // creamos 2 paginas en blanco al FINAL del doc
            doc.addPage(pagina2);

        // Creando la instancia
        Splitter splitter = new Splitter();

        // Dividiendo el documento
        List<PDDocument> Paginas = splitter.split(doc);

        Iterator<PDDocument> iterador = Paginas.listIterator();

        int i = 1;
        while (iterador.hasNext()) {
            PDDocument pd = iterador.next();
            pd.save("D:\\Personal Data\\CLASES U\\Progra\\Java\\PDFpractica\\PDFbox Test3\\TEST.PDF" + i++ + ".pdf");
        }
        System.out.println("División de PDF's exitosa.");

        doc2.close();

        /**
         * @brief Continuando la parte de Splitter
         * Con el nuevo archivo generado
         */

        // Leer del archivo
        File arch3 = new File("D:\\Personal Data\\CLASES U\\Progra\\Java\\PDFpractica\\PDFbox Test3\\TEST.PDF1.PDF");
        PDDocument doc3 = Loader.loadPDF(arch3); // Lo cargamos con la librería LOADER --importante

        // Corregir la referencia del documento para obtener el número de páginas
        int numPag3 = doc3.getNumberOfPages();
        System.out.println("Número de páginas en doc3: " + numPag3);

        // Verificar que el documento contenga al menos una página
        if (numPag3 < 1) {
            System.err.println("El documento no contiene páginas.");
            doc3.close();
            return;
        }

        // Tomamos la página en la que queremos escribir
        PDPage hoja3 = doc3.getPage(0);

        // Crear el flujo de contenido para la página seleccionada
        PDPageContentStream flujo3 = new PDPageContentStream(doc3, hoja3);

        // Iniciar el bloque de texto
        flujo3.beginText();

        // Establecer la posición donde comienza a escribir (puedes ajustar según tus necesidades)
        flujo3.newLineAtOffset(25, 25); // "coordenada" donde empieza a escribir

        // Establecer la fuente y el tamaño de las letras de manera simplificada
        flujo3.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12); // Fuente y tamaño de letras

        // Texto que queremos escribir
        String texto3 = "Nuevo texto";
        flujo3.showText(texto3);

        // Finalizar el bloque de texto y cerrar el flujo
        flujo3.endText();
        flujo3.close();

        // Guardar los cambios en el mismo archivo
        doc3.save(arch3);
        System.out.println("Texto añadido exitosamente a " + arch3.getName() + ".");

        // Cerrar el documento
        doc3.close();

        System.out.println("Texto añadido exitosamente a TEST.PDF1.PDF.");

        /**
         * @brief Ahora haciendo un merge de ambos archivos luego del Split
         */

        File archivo1 = new File("D:\\Personal Data\\CLASES U\\Progra\\Java\\PDFpractica\\PDFbox Test3\\TEST.PDF");
        File archivo2 = new File("D:\\Personal Data\\CLASES U\\Progra\\Java\\PDFpractica\\PDFbox Test3\\TEST.PDF1.PDF");

        // Instanciando PDFMergerUtility class
        PDFMergerUtility PDFmerge = new PDFMergerUtility();

        // Configurando destino del archivo
        PDFmerge.setDestinationFileName(
          "D:\\Personal Data\\CLASES U\\Progra\\Java\\PDFpractica\\PDFbox Test3\\Merged.pdf");

        // Eligiendo los archvos a unir
        PDFmerge.addSource(archivo1);
        PDFmerge.addSource(archivo2);

        // Uniendo archivos
        PDFmerge.mergeDocuments(null);
        System.out.println("Archivos Unidos con exito.");

        return;
        /*
        //seccion de notacion de otras funciones y detalles..

        //para eliminar hojas:
        //tomamos el total de paginas del documento, sirve para no pasarse del indice si no conoces la cantidad de
        paginas o quieres buscar cierta pagina. int numPag = doc.getNumberOfPages(); System.out.println(numPag);
        //esto actua como un array, dependiendo de que index llamamos, dicha pagino se borra:
        //pg 1 = indx 0 ; pag 2 = indx 1 ; pag 3 = indx 2 ;etc...
        //doc.removePage(indx);
        doc.removePage(2);//elimina la pagina 3


        //propiedades de documento..
        //informacion relevante para el documento como la fecha de creacion, autor, titulo y mas..
        //este tipo de informacion se escribe al crear el programa, siempre se puede modificar pero no es la idea
        tecnicamente.
        // es especial con la fecha de creacion-- Pues hay una fecha de modificacion-

        //cargamos la ""casilla de informacion"" del doc que estamos trabajando en
        PDDocumentInformation  info = doc.getDocumentInformation();

        //autor  -piensa escritor
        info.setAuthor("Patricio Vejar");

        //Nombre doc  -piensa titulo
        info.setTitle("PDF de practica");

        //Creador del doc   -piensa editorial
        info.setCreator("Ejemplos pdf");

        //sujeto  -piensa tematica
        info.setSubject("practicas de pdf");

        //tomamos la fecha actual del dispositivo           -- LA FUNCION setCreationDate.. REQUIERE DATO DEL TIPO
        Calendar  --- Por eso toda esta conversion de dato SimpleDateFormat sdf = new SimpleDateFormat ("d-M-yyyy
        hh:mm:ss"); String fechaActual = sdf.format(new Date()); Date date = sdf.parse(fechaActual); Calendar calendar =
        Calendar.getInstance(); calendar.setTime(date);

        //escribimos la fecha de creacion del archivo..
        //info.setCreationDate(Calendar fecha);
        info.setCreationDate(calendar);

        //escribimos la ultima fecha de modificacion del archivo.. Esto se llamaria cada vez que el archivo es cargado y
        se le hace algo. Se llama casi siempre a diferencia de setCreationDate calendar.set(2004,6,3);
        info.setModificationDate(calendar);

        //palabras clave del documento  -podria ser que lees el documento y tomas las palabras mas relevantes?
        info.setKeywords("Test, Pruebas, pdf");


        //tambien, a la par de escribirlos. Puedes leerlos..

        System.out.println("Author of the document is :"+ info.getAuthor());
        System.out.println("Title of the document is :"+ info.getTitle());
        System.out.println("Subject of the document is :"+ info.getSubject());

        System.out.println("Creator of the document is :"+ info.getCreator());
        System.out.println("Creation date of the document is :"+ info.getCreationDate());
        System.out.println("Modification date of the document is :"+ info.getModificationDate());
        System.out.println("Keywords of the document are :"+ info.getKeywords());
*/
    }
}

// https://www.tutorialspoint.com/pdfbox/pdfbox_javascript_in_pdf_document.htm