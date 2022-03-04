package util;

public class getContentsFromFile {
    public array <String> fileHandle( boolean typeFile){
        if(typeFile){
            //default CSV
            String csv = fileCSV();
            return csv;
        }
        String txt = fileTXT();
        return txt;
    }

    public String fileCSV(){
        

        return "CSV";
    }

    public String fileTXT(){


        return "TXT";
    }
}
