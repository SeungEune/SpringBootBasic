package lee.SpringBootBasicProject.main.example.service.impl;

import lee.SpringBootBasicProject.main.example.dto.ExampleType2Dto;
import lee.SpringBootBasicProject.main.example.dto.ExampleType1Dto;
import lee.SpringBootBasicProject.main.example.mapper.ExampleConvert;
import lee.SpringBootBasicProject.main.example.mapper.ExampleMapper;
import lee.SpringBootBasicProject.main.example.service.ExampleService;
import lee.SpringBootBasicProject.main.example.vo.ExampleType1VO;
import lee.SpringBootBasicProject.main.example.vo.ExampleType2VO;
import lee.SpringBootBasicProject.main.utils.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleMapper exampleMapper;

    @Autowired
    private ModelMapper modelMapper;

//-----------------DTO, VO class내 Convert Method가 있는 형식---------------------
    public ExampleType1Dto exampleType1(ExampleType1Dto exampleType1Dto){
        String codeClcd = exampleType1Dto.getCodeClcd();
        ExampleType1VO exampleType1VO = exampleMapper.selectExampleType1(codeClcd);

        //비즈니스 로직 수행 시작
        //... 가정
        //... 가정
        //비즈니스 로직 수행 끝

        return exampleType1VO.toDto();
    }

    public List<ExampleType1Dto> exampleType1List(ExampleType1Dto exampleType1Dto){
        List<ExampleType1VO> exampleType1VOList = exampleMapper.selectExampleType1List(exampleType1Dto);

        if(exampleType1VOList.isEmpty()){
            return new ArrayList<>();
        }

        List<ExampleType1Dto> resultDto = exampleType1VOList.stream().map(p -> p.toDto()).collect(Collectors.toList());

        //비즈니스 로직 수행 시작
        //... 가정
        //... 가정
        //비즈니스 로직 수행 끝

        return resultDto;
    }
//-----------------DTO, VO class내 Convert Method가 있는 형식---------------------




//-----------------ModelMapper 라이브러리를 사용하는 형식---------------------
    public ExampleType2Dto exampleType2(ExampleType2Dto exampleType2Dto){

        String codeClde = exampleType2Dto.getCodeClcd();
        ExampleType2VO exampleType2VO = exampleMapper.selectExampleType2(codeClde);

        //비즈니스 로직 수행 시작
        //... 가정
        //... 가정
        //비즈니스 로직 수행 끝

        //방법 1 : 직접 처리한다.
        //ExampleType2Dto result = modelMapper.map(exampleType2VO, ExampleType2Dto.class);

        //방법 2 : 현 Class에 Method를 구현한다.
        //ExampleType2Dto result = map(exampleType2VO, ExampleType2Dto.class);

        //방법 3 : Util Class를 생성하여 구현한다.
        ExampleType2Dto result = ModelMapperUtil.map(exampleType2VO, ExampleType2Dto.class);

        return result;
    }

    private <D, T> D map( T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    public List<ExampleType2Dto> exampleType2List(ExampleType2Dto exampleType2Dto){

        List<ExampleType2VO> exampleType2VOList = exampleMapper.selectExampleType2List(exampleType2Dto);

        if(exampleType2VOList.isEmpty()){
            return new ArrayList<>();
        }

        //방법 1 : 직접 처리한다.
        //List<ExampleType2Dto> resultDto = exampleType2VOList.stream().map(p -> modelMapper.map(p, ExampleType2Dto.class)).collect(Collectors.toList());

        //방법 2 : 현 Class에 Method를 구현한다.
        //List<ExampleType2Dto> resultDto = mapList(exampleType2VOList, ExampleType2Dto.class);

        //방법 3 : Util Class를 생성하여 구현한다.
        List<ExampleType2Dto> resultDto = ModelMapperUtil.mapAllList(exampleType2VOList, ExampleType2Dto.class);

        //비즈니스 로직 수행 시작
        //... 가정
        //... 가정
        //비즈니스 로직 수행 끝

        return resultDto;
    }

    private <S, T> List<T> mapList(List<S> source, Class<T> targetClass){
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }
//-----------------ModelMapper 라이브러리를 사용하는 형식---------------------



//-----------------Class를 따로 생성하여 convert Method 구현 형식---------------------
    public ExampleType1Dto exampleType3(ExampleType1Dto exampleType1Dto){
        String codeClcd = exampleType1Dto.getCodeClcd();
        ExampleType1VO exampleType1VO = exampleMapper.selectExampleType1(codeClcd);

        ExampleConvert exampleConvert = new ExampleConvert();
        return exampleConvert.toDtoConvertClass(exampleType1VO);
    }

    public List<ExampleType1Dto> exampleType3List(ExampleType1Dto exampleType1Dto){
        List<ExampleType1VO> exampleType1VOList = exampleMapper.selectExampleType1List(exampleType1Dto);

        if(exampleType1VOList.isEmpty()){
            return new ArrayList<>();
        }

        ExampleConvert exampleConvert = new ExampleConvert();
        List<ExampleType1Dto> resultDto = exampleConvert.toDtoListConvertClass(exampleType1VOList);

        //비즈니스 로직 수행 시작
        //... 가정
        //... 가정
        //비즈니스 로직 수행 끝

        return resultDto;
    }
//-----------------Class를 따로 생성하여 convert Method 구현 형식---------------------

}
