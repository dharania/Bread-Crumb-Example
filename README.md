# Bread-Crumb-Example
Bread crumb component in AEM

This is a simple breadcrumb component build for demonstration purpose only. This might not work as is as it assumes default homepage as: "/content/sites/geometrixx/en". Devs will need to update the path so it points to their site's home page.

This component allows authors to hide (black list) some pages in the content tree. This is handled through component dialog currently, so this needs to be authored in every single page. For best usability, it's better to make this component authorable in homepage only and every subsequent page inherit that data.
