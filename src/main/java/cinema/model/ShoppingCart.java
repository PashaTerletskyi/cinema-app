package cinema.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {
    @Id
    private Long id;
    @OneToMany
    @JoinTable(name = "shopping_carts_tickets",
            joinColumns = @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private List<Ticket> tickets;
    @MapsId
    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoppingCart{"
                + "id=" + id
                + ", tickets=" + tickets
                + ", user=" + user + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        ShoppingCart that = (ShoppingCart) object;
        return Objects.equals(id, that.id)
                && Objects.equals(tickets, that.tickets)
                && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tickets, user);
    }
}
