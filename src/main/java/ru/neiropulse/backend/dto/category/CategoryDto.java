package ru.neiropulse.backend.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private int id;

    private String name;

    private boolean isHidden;

    public boolean getIsHidden(){
        return this.isHidden;
    }
}