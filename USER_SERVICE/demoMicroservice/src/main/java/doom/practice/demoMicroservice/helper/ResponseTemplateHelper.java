package doom.practice.demoMicroservice.helper;

import doom.practice.demoMicroservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateHelper {
    private User user;
    private Department department;
}
