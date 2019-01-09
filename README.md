# Bread-Crumb-Example
Bread crumb component in AEM

This is a simple breadcrumb component for demonstration purpose only. This might not work as is since it assumes default homepage as: "/content/sites/geometrixx/en". Before installing this you would need to update the home page path on java class: BreadCrumbDataProvider.java, so it points to your site's home page.

This component allows authors to hide (black list) some pages in the content tree. This is handled through component dialog currently, so this needs to be authored in every single page. For best usability, it's better to make this component authorable in homepage only and embedd the authored component on subsequent/child pages.
