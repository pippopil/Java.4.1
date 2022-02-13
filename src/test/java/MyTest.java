import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.CartRepository;
import ru.netology.domain.PurchaseItem;

public class MyTest {
    CartRepository repo = new CartRepository();

    PurchaseItem first = new PurchaseItem(1, 1, "first", 100, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 11, 1);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);

    @Test
    public void shouldGetNotFoundException() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });

    }

    @Test
    public void shouldRemoveById() {
        repo.save(first);
        repo.removeById(1);
    }

}
