package com.github.pedrovgs.tuentitv.presenter;

import com.github.pedrovgs.tuentitv.model.Accounts;
import com.github.pedrovgs.tuentitv.model.CardInfo;
import com.github.pedrovgs.tuentitv.model.Contact;
import com.github.pedrovgs.tuentitv.model.ConversationSummary;
import com.github.pedrovgs.tuentitv.model.MediaElement;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Class created to work as main view presenter. This presenter has all the responsibility related
 * to the main view presentation logic.
 *
 * Responsibilities:
 *
 * - Obtains a list of favorite contacts.
 *
 * - Obtains a list of recent conversations.
 *
 * - Show a list of all user's contacts sorted alphabetically.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MainPresenter {

  private final Accounts accounts;
  private View view;

  @Inject public MainPresenter(Accounts accounts) {
    this.accounts = accounts;
  }

  public void setView(View view) {
    this.view = view;
  }

  public void loadData() {
    view.showDefaultBackground();
    List<CardInfo> favorites = getFavoriteContacts();
    List<CardInfo> conversations = getConversations();
    List<CardInfo> contacts = getAllContacts();
    List<CardInfo> mediaElements = getAllMediaElements();
    view.showMainInformation(favorites, conversations, contacts, mediaElements);
  }

  public void onCardInfoSelected(CardInfo cardInfo) {
    if (cardInfo != null) {
      view.updateBackground(cardInfo.getSecondaryImage());
    }
  }

  public void onPreferencesSelected() {
    view.showDefaultBackground();
  }

  public void onSearchIconClicked() {
    view.openSearchView();
  }

  public void logout() {
    accounts.logout();
    view.closeAndGoToLoginActivity();
  }

  private List<CardInfo> getFavoriteContacts() {
    List<CardInfo> favorites = new ArrayList<CardInfo>();
    favorites.add(new Contact("Fina Perez", "https://imrl.tuenti.net/Mev9lAPPtkUlXKrgAA",
        "https://imrl.tuenti.net/Me4jFwTDI0SJxk1fAA"));
    favorites.add(new Contact("Joaquin Engelmo", "https://imrl.tuenti.net/MeqNvwQ3IFNBDGnUAA",
        "https://imrl.tuenti.net/MejJ5wRt9SGPKzF-AA"));
    favorites.add(new Contact("Juanjo Torroglosa", "https://imrl.tuenti.net/IMwzMQOv3yxSsLLxAA",
        "https://imrl.tuenti.net/Mevl_gS9EGaDmKQ7AA"));
    favorites.add(new Contact("Víctor Corugedo", "https://imrl.tuenti.net/MczWnAPlHhALIiljAA",
        "https://imrl.tuenti.net/MejiHgP0dhCo4kjrAA"));
    favorites.add(new Contact("Iván Mosquera", "https://imrl.tuenti.net/Mek7iQPYc565Wkj7AA",
        "https://imrl.tuenti.net/MepPAQS-zo6Lc9gnAA"));
    return favorites;
  }

  private List<CardInfo> getConversations() {
    List<CardInfo> conversations = new ArrayList<CardInfo>();
    conversations.add(new ConversationSummary("Android Developers",
        "http://www.androidguys.com/wp-content/uploads/2011/12/android-developer-logo.png",
        "Pull request sent!!"));
    conversations.add(
        new ConversationSummary("Andu Fratu", "https://imrl.tuenti.net/MewKTgRZKByd5oZ9AA",
            "Hey, do you have the test ready?"));
    conversations.add(
        new ConversationSummary("Carmen Barroso", "https://imrl.tuenti.net/MexNAAOXqRoOXZcYAA",
            "Bye!"));
    conversations.add(
        new ConversationSummary("Cesar Estébanez", "https://imrl.tuenti.net/MeqsBwSymhO82EB9AA",
            "Hey, do you have the test ready?"));
    conversations.add(
        new ConversationSummary("Eduardo Ramirez", "https://imrl.tuenti.net/Mef8vgRt9SHKr5U0AA",
            "Do you come to the kitchen??"));
    conversations.add(
        new ConversationSummary("Laura Rus", "https://imrl.tuenti.net/MefvswOREWiM7ehEAA",
            "I have news!! :)"));
    conversations.add(
        new ConversationSummary("Roberto Fernández", "https://imrl.tuenti.net/Me2X1ATgzxoIlIjAAA",
            "I've a problem with one animation, can you help me?"));
    conversations.add(
        new ConversationSummary("David Santiago", "https://imrl.tuenti.net/Me4XWwQtq65VyIUVAA",
            "Beers after work?"));
    return conversations;
  }

  private List<CardInfo> getAllContacts() {
    List<CardInfo> contacts = new ArrayList<CardInfo>();
    contacts.add(new Contact("Aarón", "https://imrl.tuenti.net/MexmzwOwyK_qaPXpAA",
        "https://imrl.tuenti.net/MeuEFQOwyK9ZMUl8AA"));
    contacts.add(new Contact("Blanca Díaz", "https://imrl.tuenti.net/MexmsQOUyDnTABlnAA",
        "https://imrl.tuenti.net/Mer_-gRUXxq_3yZqAA"));
    contacts.add(new Contact("Carmen Barroso", "https://imrl.tuenti.net/MexNAAOXqRoOXZcYAA",
        "https://imrl.tuenti.net/MepPIQS-zo5ircngAA"));
    contacts.add(new Contact("Carlos Perez", "https://imrl.tuenti.net/ILQtUgOLW18w1mHaAA",
        "https://imrl.tuenti.net/MeOI0gOLW19UOvNpAA"));
    contacts.add(new Contact("Cesar Estébanez", "https://imrl.tuenti.net/MeqsBwSymhO82EB9AA",
        "https://imrl.tuenti.net/MeoZRgOOOk3wInOMAA"));
    contacts.add(new Contact("Diana Hernández", "https://imrl.tuenti.net/MeUzdwP0dhA6dQhWAA",
        "https://imrl.tuenti.net/MehaCQP0dhAyjmn_AA"));
    contacts.add(new Contact("Eduardo Ramirez", "https://imrl.tuenti.net/Mef8vgRt9SHKr5U0AA",
        "https://imrl.tuenti.net/MelqgQS-zo7D2jUkAA"));
    contacts.add(new Contact("Eduardo Gonzalez", "https://imrl.tuenti.net/MeHopQQgmSi7GQGdAA",
        "https://imrl.tuenti.net/MeoZRAOOOk07kA8MAA"));
    contacts.add(new Contact("Fernando Cejas", "https://imrl.tuenti.net/MeyKggSu6c3B22wiAA",
        "https://imrl.tuenti.net/Meo-kQTBiDZBKnC9AA"));
    contacts.add(new Contact("Joaquin Engelmo", "https://imrl.tuenti.net/MeqNvwQ3IFNBDGnUAA",
        "https://imrl.tuenti.net/MexxswOZ9UAkEFn6AA"));
    contacts.add(new Contact("Laura Rus", "https://imrl.tuenti.net/MefvswOREWiM7ehEAA",
        "https://imrl.tuenti.net/MeOW2gOREWgfCrI-AA"));
    contacts.add(new Contact("Manolo Vera", "https://imrl.tuenti.net/MeskMwOsS3aHCO-fAA",
        "https://imrl.tuenti.net/MehZuwOTKRmei3V-AA"));
    contacts.add(new Contact("Sebas Muriel", "https://imrl.tuenti.net/CZ-M0wOhf0IbHVN2AA",
        "https://imrl.tuenti.net/MePi1gOhf0LH0aG8AA"));
    return contacts;
  }

  private List<CardInfo> getAllMediaElements() {
    List<CardInfo> mediaElements = new ArrayList<CardInfo>();
    mediaElements.add(
        new MediaElement("Augmented Reality day :)", "https://imrl.tuenti.net/MeVNOAO1hS95RMX9AA"));
    mediaElements.add(
        new MediaElement("Madrid: 4 - BCN: 0 ", "https://imrl.tuenti.net/Me2XLwONIBZEgj76AA"));
    mediaElements.add(
        new MediaElement("Congrats!!!", "https://imrl.tuenti.net/MephbgPFZwIHmNz3AA"));
    mediaElements.add(
        new MediaElement("Happy hallowing!", "https://imrl.tuenti.net/MepO8AS-zo4tbPwOAA"));
    mediaElements.add(
        new MediaElement("I hate mondays :_(", "https://imrl.tuenti.net/Melh1wOmYV2w27UHAA"));
    mediaElements.add(new MediaElement("Take a look at the hat xD",
        "https://imrl.tuenti.net/MevCbwOhf0Kgn2LmAA"));
    mediaElements.add(
        new MediaElement("After work at Tuenti", "https://imrl.tuenti.net/MevCdQOhf0IzmO7bAA"));
    mediaElements.add(new MediaElement("Cloud phone team picture \\o/",
        "https://imrl.tuenti.net/Mej6IwPYc55jJ3OuAA"));
    mediaElements.add(
        new MediaElement("Design team building!", "https://imrl.tuenti.net/MekIYwS-zo6iTThqAA"));
    mediaElements.add(
        new MediaElement("Love is in the air <3", "https://imrl.tuenti.net/MegZXgOmYV2hznMJAA"));
    mediaElements.add(
        new MediaElement("Fifa 14 winners!", "https://imrl.tuenti.net/MeoEZARzE9_n9j5bAA"));
    mediaElements.add(
        new MediaElement("Murcian experts xD", "https://imrl.tuenti.net/MepPHAS-zo4pJD4gAA"));
    mediaElements.add(
        new MediaElement("Free donuts, yeah!", "https://imrl.tuenti.net/Meo8egTBiDawcvM3AA"));
    mediaElements.add(new MediaElement("Really???", "https://imrl.tuenti.net/Me0keARq1hWI_3FFAA"));
    return mediaElements;
  }

  public interface View {

    void updateBackground(String imageUrl);

    void showMainInformation(List<CardInfo> favorites, List<CardInfo> conversations,
        List<CardInfo> contacts, List<CardInfo> mediaElements);

    void showDefaultBackground();

    void openSearchView();

    void closeAndGoToLoginActivity();
  }
}