package pers.nefedov.demoshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.nefedov.demoshop.dto.DesktopDto;
import pers.nefedov.demoshop.entities.Desktop;
import pers.nefedov.demoshop.repositories.DesktopRepository;
import pers.nefedov.demoshop.utils.DesktopMappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesktopService {
    private final DesktopMappingUtils desktopMappingUtils = new DesktopMappingUtils();
    @Autowired
    DesktopRepository desktopRepository;
    //DesktopMappingUtils desktopMappingUtils;

    public void save(DesktopDto desktopDto) {
        Desktop desktop = desktopMappingUtils.mapToDesktopEntity(desktopDto);
        desktopRepository.save(desktop);
    }

    public List<DesktopDto> findAll() {
        return desktopRepository.findAll().stream().
                map(desktopMappingUtils::mapToDesktopDto).collect(Collectors.toList());
    }

    public DesktopDto findById(long id) {
        return desktopMappingUtils.mapToDesktopDto(desktopRepository.findById(id).orElse(new Desktop()));
    }

    public void update(DesktopDto desktopDto) {
    }
}
/* todo
    При GET-запросах нужно возвращать ID товара тоже, а при сохранении нового - ID не используется. (решено -
    внес изменения в класс mapping).
    Реализовать update.
    Если товар уже есть в базе, то увеличить количество, а если нет - создать новую запись
    Добавить слой фасадов
    Добавить авторизацию


 */