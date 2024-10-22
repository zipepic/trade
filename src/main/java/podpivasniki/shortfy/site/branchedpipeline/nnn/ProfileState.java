package podpivasniki.shortfy.site.branchedpipeline.nnn;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;
@RequiredArgsConstructor
@Data
@ToString
public class ProfileState {
    private final Map<String,Integer> stocks;
}
