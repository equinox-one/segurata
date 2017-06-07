## Segurata
Segurata is a model validator for Java that uses annotations to define contstraints.

## Example
Lets create the following model that uses Segurata annotations.
```java
public class SampleModel {
        @NotNull
        String notNull;
        @NotEmpty String notEmpty;
        @NotEmpty List<String> notEmptyList;
        @Max(10) int max10;
        @Min(10) int min10;
        @GreaterThan(attribute=MAX10) int greaterThanMax10;
        @GreaterThan(attribute=MAX10, acceptEqual=true) int greaterOrEqualThanMax10;
        @MatchesPattern(pattern = "A.*B") String matchesPattern;
}
```
We have defined a constraint for each of the attributes of the model.

```java
Segurata segurata = new Segurata();
SampleModel model = new SampleModel();
//set attributes to the model
List<ValidationError> errors = segurata.validate(model);
if(errors.isEmpty()){
    System.out.println("Invalid model")
}
```

## Download
You can get it from graddle or maven:
```groovy
repositories { jcenter() }

compile 'one.equinox.pillow:segurata:0.0.+'
```

License
=======

     Copyright 2016 Equinox.one

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.

