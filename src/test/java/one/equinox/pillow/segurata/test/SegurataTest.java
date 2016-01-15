package one.equinox.pillow.segurata.test;


import one.equinox.pillow.segurata.Validator;
import one.equinox.pillow.segurata.Segurata;
import one.equinox.pillow.segurata.errors.ValidationError;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class SegurataTest {
    Segurata segurata = new Segurata();

    @Test
    public void validModel(){
        List<ValidationError> errors = segurata.validate(createValidSampleModel());
        assertTrue(errors.isEmpty());
    }

    @Test
    public void validNotNullWithEmpty(){
        SampleModel model = createValidSampleModel();
        model.setNotNull("");
        List<ValidationError> errors = segurata.validate(model);
        assertTrue(errors.isEmpty());
    }


    @Test
    public void invalidPattern(){
        SampleModel model = createValidSampleModel();
        model.setMatchesPattern("aaaaaa");
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidPatternWithNull(){
        SampleModel model = createValidSampleModel();
        model.setMatchesPattern(null);
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidNotNull(){
        SampleModel model = createValidSampleModel();
        model.setNotNull(null);
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidNotEmptyListWithEmpty(){
        SampleModel model = createValidSampleModel();
        model.setNotEmptyList(new ArrayList<String>());
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidNotEmptyListWithNull(){
        SampleModel model = createValidSampleModel();
        model.setNotEmptyList(null);
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidNotEmptyWithEmpty(){
        SampleModel model = createValidSampleModel();
        model.setNotEmpty("");
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidNotEmptyWithNull(){
        SampleModel model = createValidSampleModel();
        model.setNotEmpty(null);
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidMax(){
        SampleModel model = createValidSampleModel();
        model.setMax10(12);
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidMin(){
        SampleModel model = createValidSampleModel();
        model.setMin10(7);
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidGreaterThan(){
        SampleModel model = createValidSampleModel();
        model.setGreaterThanMax10(4);
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void invalidGreaterThanEquals(){
        SampleModel model = createValidSampleModel();
        model.setGreaterOrEqualThanMax10(4);
        List<ValidationError> errors = segurata.validate(model);
        assertEquals(errors.size(), 1);
    }

    private SampleModel createValidSampleModel(){
        return new SampleModel();
    }
}
