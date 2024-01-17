package test.toypj.domain.board;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Board {

    private Long id;
    private String title;
    private String content;
//    private List<UploadFile> imageFiles;

    public Board() {
    }

//    public Board(String title, String content, List<UploadFile> imageFiles) {
//        this.title = title;
//        this.content = content;
//        this.imageFiles = imageFiles;
//    }


    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
