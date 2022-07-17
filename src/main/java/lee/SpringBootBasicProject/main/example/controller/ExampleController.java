package lee.SpringBootBasicProject.main.example.controller;

import lee.SpringBootBasicProject.main.example.dto.ExampleType2Dto;
import lee.SpringBootBasicProject.main.example.dto.ExampleType1Dto;
import lee.SpringBootBasicProject.main.example.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 예제 Controller Class
 * - 현 Controller는 restApi 형식으로 구현하기 위해 @RestController anntation을 사용한다.
 * - logging은 Spring에서 지원하는 @Slf4j annotation을 사용한다.
 */
@Slf4j
@RestController
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    /**
     * 예제 Contoller Method
     * - 현 프로젝트에선 DTO, VO를 구분하여 사용하길 권장한다.
     * - DTO 사용 범위는 serviceImpl까지이며, 실제 Database와의 connection에선 VO를 사용한다.
     * - 즉, service Layer는 dto를 repository layer는 domain(vo)를 사용하자.
     * - DTO(@Getter, @Setter), VO(@Getter)만 사용
     *
     * - 또한, @GetMapping, @PostMapping 등 요청 Type을 구분하여 사용하길 권장한다.
     */

    @GetMapping("/basicController/{codeClcd}")
    public ExampleType1Dto basicController(@PathVariable("codeClcd") String codeClcd){

        //컨트롤러에서 꼭 파라미터 유효성 체크를 한다!!
        //아래 로직은 그냥 참고... 좀 더 좋은 방법이 있다면 찾는다.
        if(codeClcd == null || "".equals(codeClcd)){
            return new ExampleType1Dto();
        }

        ExampleType1Dto exampleType1Dto = new ExampleType1Dto();
        exampleType1Dto.setCodeClcd(codeClcd);

        return exampleService.exampleType1(exampleType1Dto);
    }

    /**
     * (!!!!!!!!!!!!!)   DTO README   (!!!!!!!!!!!!!)
     *
     * DTO 사용 방법 참조 -> https://www.amitph.com/spring-entity-to-dto/
     *
     * Type1 방식과 Type2 방식의 차이점에 대한 내 생각은....
     * Type1(dto, vo class 안에 convert)는 VO에도 Setter가 들어가야한다.
     * 그러면 개발자이 혼용해서 쓸 확률이 높지 않을까??? 귀찮아서 그냥 DTO만 쓴다든가.. VO만 쓴다든가 하는???
     * 다만, Type1 방법을 쓰면 DTO에 필요한 Entity를 넣고 빼고가 쉬울꺼 같다..
     * setEntity(this.getName) 한줄만 넣으면 되니... -> 변수 명이 달라도 쉽게 변경 가능
     *
     *
     * ModelMapper라이브러리 기능 참조(잘 정리 되어있다.)-> https://devwithpug.github.io/java/java-modelmapper/
     * Type2(ModelMapper 라이브러리 사용)는 위에서 말한 Setter는 안써도 되니
     * 아애 Set을 할 수가 없다... 혼용 불가하지 않을까???
     * 하지만!! 큰 문제는 DTO와 VO 간 변수명이 다를때 적용이 힘들다..
     *
     * modelMapper.typeMap(Item.class, Bill.class).addMappings(mapper -> {
     *         mapper.map(Item::getStock, Bill::setQty);
     *         mapper.map(Item::getPrice, Bill::setSinglePrice);
     *         mapper.using((Converter<Boolean, Double>) context -> context.getSource() ? 20.0 : 0.0)
     *                 .map(Item::isSale, Bill::setDiscount);
     *     }); -> (map) : 변수명이 다른 경우, (using) : 타입이 다른 경우
     *
     * 이런 형식으로 변환을 해주어야함...
     *
     *
     * Type3(Class Method 구현 방식)은 Type1과 별만 다를바 없는거 같다...
     */
//-----------------DTO, VO class내 Convert Method가 있는 형식---------------------

    /**
     * 단일 객체
     *
     * @param ExampleType1Dto
     * @return
     */
    @GetMapping(value = "/exampleType1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExampleType1Dto exampleType1(@ModelAttribute ExampleType1Dto ExampleType1Dto) {
        return exampleService.exampleType1(ExampleType1Dto);
    }

    /**
     * list Type
     * selectAll이라 굳이 parameter은 필요없지만...
     *
     * @param exampleType1Dto
     * @return
     */
    @GetMapping(value = "/exampleType1List", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleType1Dto> exampleType1List(@ModelAttribute ExampleType1Dto exampleType1Dto) {
        return exampleService.exampleType1List(exampleType1Dto);
    }
//-----------------DTO, VO class내 Convert Method가 있는 형식---------------------


//-----------------ModelMapper 라이브러리를 사용하는 형식---------------------

    /**
     * 단일 객체
     *
     * @param exampleType2Dto
     * @return
     */
    @GetMapping(value = "/exampleType2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExampleType2Dto exampleType2(@ModelAttribute ExampleType2Dto exampleType2Dto) {
        return exampleService.exampleType2(exampleType2Dto);
    }

    /**
     * list Type
     * selectAll이라 굳이 parameter은 필요없지만...
     *
     * @param exampleType2Dto
     * @return
     */
    @GetMapping(value = "/exampleType2List", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleType2Dto> exampleType2List(@ModelAttribute ExampleType2Dto exampleType2Dto) {
        return exampleService.exampleType2List(exampleType2Dto);
    }
//-----------------ModelMapper 라이브러리를 사용하는 형식---------------------



//-----------------Class를 따로 생성하여 convert Method 구현 형식---------------------
    @GetMapping(value = "/exampleType3", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExampleType1Dto exampleType3(ExampleType1Dto exampleType1Dto){
        return exampleService.exampleType3(exampleType1Dto);
    }

    @GetMapping(value = "/exampleType3List", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ExampleType1Dto> exampleType3List(@ModelAttribute ExampleType1Dto exampleType1Dto) {
        return exampleService.exampleType3List(exampleType1Dto);
    }
//-----------------Class를 따로 생성하여 convert Method 구현 형식---------------------


}
