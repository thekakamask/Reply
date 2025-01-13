# 📧 **Reply**
**Reply** is a modern Android application that simulates an email client. It lets you view, organize, and interact with emails using Android development best practices, including Jetpack Compose and an MVVM architecture.

## 🚀 **Features**
   - 📂 **Mailbox browsing**:
      - Access different categories: Inbox, Drafts, Sent, Spam.
      - Easily change categories via a Navigation Rail, Navigation Drawer and Bottom Navigation Bar (depending on hardware screen size).
   - ✉️ **Email list**:
      - View the list of emails associated with each inbox.
      - Select an email to view its contents in detail.
   - 📜 **Email details**:
      - View an email's information: sender, recipients, subject, message body, date sent.
      - Different actions possible depending on category:
         - Reply or reply all.  🔴 <span style="color: red;">**NOT WORKING YET**</span>
         - Continue writing a draft. 🔴 <span style="color: red;">**NOT WORKING YET</span>
         - Move an e-mail from Spam to Inbox. 🔴 <span style="color: red;">**NOT WORKING YET**</span>
         - Permanently delete an unwanted email. 🔴 <span style="color: red;">**NOT WORKING YET**</span>
   - 🎨 **Modern, fluid interface**:
      - Use of Jetpack Compose for a declarative interface.
      - Material 3 integration for accessible, modern design.
      - Support for dark and light themes.
      - Use of windowSizeClass to display a better user interface depending on screen size.

## 🛠️ **Tech Stack**:
   - Kotlin: Modern, concise language for Android development.
   - Jetpack Compose: Declarative UI toolkit for Android.
   - Material 3: Modern, accessible user interface.
   - StateFlow: Reactive state management for real-time updates.
   - ViewModel: MVVM architecture to separate business logic from user interface.

## 📦 **Project Structure**
**Packages**:
1. **Data**:
   - Defines data models for emails and user accounts:
      - **MailboxType**: Enum for different email categories (Inbox, Drafts, etc.).
      - **Email**: Data model to represent an email.
      - **Account**: Data model to represent a user account.
2. **data.local**:
   - Provides static data to simulate user accounts and emails:
      - **LocalAccountsDataProvider**: Contains fictitious user accounts.
      - **LocalEmailsDataProvider**: Contains the list of fictitious emails.
3. **Ui**:
   - Implements the user interface using Jetpack Compose:
      - **ReplyApp**: application's main entry point.
      - **ReplyHomeScreen**: Manages navigation and display of email lists.
      - **ReplyDetailsScreen**: Displays the details of a selected email.

## 🚀 **How to Use**
1. **Launch the App**:
   - Open the app on a Android device or emulator.
2. **Navigate between categories**:
   - Use the Navigation Rail, the bottom navigation bar, or the Navigation Drawer to access different mailboxes.
3. **View an email**:
   - Tap an email in the list to see its details.
4. **Perform actions**:
   - Reply, continue writing, or delete depending on the email category.